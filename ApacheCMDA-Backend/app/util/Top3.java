package util;

import java.util.List;
import java.util.ArrayList;
import models.Workflow;
import models.WorkflowRepository;
import util.Constants;
import util.RepoFactory;

public class Top3 {
    
    private List<Workflow> topWorkflows;

    private static Top3 instance = new Top3();

    private Top3() {
        WorkflowRepository workflowRepository = (WorkflowRepository) RepoFactory.getRepo(Constants.WORKFLOW_REPO);
        this.topWorkflows = workflowRepository.findTop3Workflow();        
    }

    public static Top3 getInstance() {
        return instance;
    } 

    public void refreshTop3() {
        WorkflowRepository workflowRepository = (WorkflowRepository) RepoFactory.getRepo(Constants.WORKFLOW_REPO);
        topWorkflows = workflowRepository.findTop3Workflow();
        System.out.println("******* Refreshed Top 3 *******");
    }

    public List<Workflow> getTopWorkflows() {
        return topWorkflows;
    }

}