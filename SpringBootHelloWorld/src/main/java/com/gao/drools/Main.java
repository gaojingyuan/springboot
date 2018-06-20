package com.gao.drools;

import org.drools.core.command.impl.ExecutableCommand;
import org.drools.core.command.runtime.BatchExecutionCommandImpl;
import org.drools.core.command.runtime.rule.FireAllRulesCommand;
import org.drools.core.command.runtime.rule.InsertObjectCommand;
import org.kie.api.KieServices;
import org.kie.api.command.Command;
import org.kie.api.command.KieCommands;
import org.kie.api.runtime.ExecutionResults;
import org.kie.server.api.marshalling.MarshallingFormat;
import org.kie.server.api.model.KieContainerResource;
import org.kie.server.api.model.KieContainerResourceList;
import org.kie.server.api.model.ReleaseId;
import org.kie.server.api.model.ServiceResponse;
import org.kie.server.client.KieServicesClient;
import org.kie.server.client.KieServicesConfiguration;
import org.kie.server.client.KieServicesFactory;
import org.kie.server.client.RuleServicesClient;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {

    public static final String SERVER_URL = "http://localhost:6160/kie-server/services/rest/server";
    public static final String USERNAME = "kieserver";
    public static final String PASSWORD = "kieserver1!";
//    public static final String KIE_CONTAINER_ID = "com.gao:hellodrools:1.0.0";
    public static final String KIE_CONTAINER_ID = "droolsContainer";

    public static void main(String[] args) {
//        run();
        getList();
//        createContainer();

    }

    private static void createContainer() {
        // 创建规则服务客户端
        boolean deployContainer = true;
        KieServicesClient kieServicesClient = getKieServicesClient();
        KieContainerResourceList containersList = kieServicesClient.listContainers().getResult();
        if (containersList != null) {
            for (KieContainerResource kieContainerResource : containersList.getContainers()) {
                if (kieContainerResource.getContainerId().equals(KIE_CONTAINER_ID)) {
                    System.out.println("######### Found container " + KIE_CONTAINER_ID + " skipping deployment...");
                    deployContainer = false;
                    break;
                }
            }
        }

        if (deployContainer) {
            final ReleaseId releaseId = new ReleaseId("com.gao","droolsContainer","1.0.0");
            KieContainerResource res = new KieContainerResource("droolsContainer", releaseId);
            kieServicesClient.createContainer("droolsContainer",res);
        }

        // work with rules
        List<ExecutableCommand<?>> commands = new ArrayList<ExecutableCommand<?>>();
        BatchExecutionCommandImpl executionCommand = new BatchExecutionCommandImpl(commands);
        executionCommand.setLookup("kieSessionId");

        InsertObjectCommand insertObjectCommand = new InsertObjectCommand();
        insertObjectCommand.setOutIdentifier("person");
        insertObjectCommand.setObject("john");

        FireAllRulesCommand fireAllRulesCommand = new FireAllRulesCommand();

        commands.add(insertObjectCommand);
        commands.add(fireAllRulesCommand);
    }

    private static void getList() {
        KieServicesClient kieServicesClient = getKieServicesClient();
        List<KieContainerResource> kieContainers = kieServicesClient.listContainers().getResult().getContainers();
        System.out.println(kieContainers);
    }

    private static void run() {
        // 创建规则服务客户端
        KieServicesClient kieServicesClient = getKieServicesClient();
        RuleServicesClient ruleServicesClient = kieServicesClient.getServicesClient(RuleServicesClient.class);

        // 规则输入条件
        ApplyInfo applyInfo = new ApplyInfo();
        applyInfo.setAge(19);
        Address familyAddress = new Address();
        familyAddress.setProvince("aa");
        applyInfo.setFamilyAddress(familyAddress);

        // 命令定义，包含插入数据，执行规则
        KieCommands kieCommands = KieServices.Factory.get().getCommands();
        List<Command<?>> commands = new LinkedList<>();
        commands.add(kieCommands.newInsert(applyInfo, "applyInfo"));
        commands.add(kieCommands.newFireAllRules());
        ServiceResponse<ExecutionResults> results = ruleServicesClient.executeCommandsWithResults(KIE_CONTAINER_ID,
                kieCommands.newBatchExecution(commands, "ksessionId"));

        // 返回值读取
        ApplyInfo value = (ApplyInfo) results.getResult().getValue("applyInfo");
        System.out.println(value);
    }

    private static KieServicesClient getKieServicesClient() {
        return KieServicesFactory.newKieServicesClient(getKieServicesConfiguration());
    }

    private static KieServicesConfiguration getKieServicesConfiguration() {
        // KisService 配置信息设置
        KieServicesConfiguration kieServicesConfiguration =
                KieServicesFactory.newRestConfiguration(SERVER_URL, USERNAME, PASSWORD, 10000L);
        kieServicesConfiguration.setMarshallingFormat(MarshallingFormat.JSON);
        return kieServicesConfiguration;
    }
}