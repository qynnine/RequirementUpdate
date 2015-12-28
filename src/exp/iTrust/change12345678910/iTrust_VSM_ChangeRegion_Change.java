package exp.iTrust.change12345678910;

import core.algo.JSS2015_CSTI;
import core.dataset.TextDataset;
import core.ir.IR;
import core.ir.IRModelConst;
import core.metrics.Result;
import exp.iTrust.ITrustSetting;

/**
 * Created by niejia on 15/12/14.
 */
public class iTrust_VSM_ChangeRegion_Change {

    public static void main(String[] args) {
        changeRegion(ITrustSetting.iTrust_Change1_GroupedByMethod,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange1, "Change1");

        changeRegion(ITrustSetting.iTrust_Change2_GroupedByMethod,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange2, "Change2");

        changeRegion(ITrustSetting.iTrust_Change3_GroupedByMethod,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange3, "Change3");

        changeRegion(ITrustSetting.iTrust_Change4_GroupedByMethod,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange4, "Change4");

        changeRegion(ITrustSetting.iTrust_Change5_GroupedByMethod,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange5, "Change5");

        changeRegion(ITrustSetting.iTrust_Change6_GroupedByMethod,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange6, "Change6");

        changeRegion(ITrustSetting.iTrust_Change7_GroupedByMethod,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange7, "Change7");

        changeRegion(ITrustSetting.iTrust_Change8_GroupedByMethod,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange8, "Change8");

        changeRegion(ITrustSetting.iTrust_Change9_GroupedByMethod,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange9, "Change9");

        changeRegion(ITrustSetting.iTrust_Change10_GroupedByMethod,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange10, "Change10");

    }


    public static void changeRegion(String code, String req, String oracle, String change) {
        System.out.println("----------" + change + "----------");
        TextDataset textDataset = new TextDataset(code,
                req, oracle);

        Result result_ir = IR.compute(textDataset, IRModelConst.VSM_ALL, new JSS2015_CSTI(), change);
        result_ir.showMatrix();
        result_ir.showAveragePrecisionByRanklist();
        System.out.println("--------------------");
    }
}
