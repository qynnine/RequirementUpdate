package exp.iTrust.change12345678910;

import core.algo.JSS2015_CSTI;
import core.dataset.TextDataset;
import core.ir.IR;
import core.ir.IRModelConst;
import core.metrics.Result;
import exp.iTrust.ITrustSetting;

/**
 * Created by niejia on 15/12/15.
 */
public class iTrust_VSM_JSEP_MyVersion_Change {

    public static void main(String[] args) {
        jsep_myversion(ITrustSetting.iTrust_Change1_GroupedByJSEP_MyVersion,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange1, "Change1");

        jsep_myversion(ITrustSetting.iTrust_Change2_GroupedByJSEP_MyVersion,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange2, "Change2");

        jsep_myversion(ITrustSetting.iTrust_Change3_GroupedByJSEP_MyVersion,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange3, "Change3");

        jsep_myversion(ITrustSetting.iTrust_Change4_GroupedByJSEP_MyVersion,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange4, "Change4");

        jsep_myversion(ITrustSetting.iTrust_Change5_GroupedByJSEP_MyVersion,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange5, "Change5");

        jsep_myversion(ITrustSetting.iTrust_Change6_GroupedByJSEP_MyVersion,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange6, "Change6");

        jsep_myversion(ITrustSetting.iTrust_Change7_GroupedByJSEP_MyVersion,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange7, "Change7");

        jsep_myversion(ITrustSetting.iTrust_Change8_GroupedByJSEP_MyVersion,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange8, "Change8");

        jsep_myversion(ITrustSetting.iTrust_Change9_GroupedByJSEP_MyVersion,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange9, "Change9");

        jsep_myversion(ITrustSetting.iTrust_Change10_GroupedByJSEP_MyVersion,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange10, "Change10");

    }


    public static void jsep_myversion(String code, String req, String oracle, String change) {
        System.out.println("----------" + change + "----------");
        TextDataset textDataset = new TextDataset(code,
                req, oracle);

        Result result_ir = IR.compute(textDataset, IRModelConst.VSM_ALL, new JSS2015_CSTI(), change);
        result_ir.showMatrix();
        result_ir.showAveragePrecisionByRanklist();
        System.out.println("--------------------");
    }
}
