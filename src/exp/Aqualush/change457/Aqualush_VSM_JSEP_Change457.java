package exp.Aqualush.change457;

import core.algo.JSS2015_CSTI;
import core.dataset.TextDataset;
import core.ir.IR;
import core.ir.IRModelConst;
import core.metrics.Result;
import exp.Aqualush.AqualushSetting;

/**
 * Created by niejia on 15/12/2.
 */
public class Aqualush_VSM_JSEP_Change457 {
    public static void main(String[] args) {
        jsep(AqualushSetting.Aqualush_Change4_GroupedByJSEP,
                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange4, "Change4");


        jsep(AqualushSetting.Aqualush_Change5_GroupedByJSEP,
                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange5, "Change5");
//
        jsep(AqualushSetting.Aqualush_Change7_GroupedByJSEP,
                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange7, "Change7");

//        int n = 20;
//        double meanAveragePrecision = (result_ir4.getAveragePrecisionByRanklistAtCutN(n) + result_ir5.getAveragePrecisionByRanklistAtCutN(n) +
//                result_ir7.getAveragePrecisionByRanklistAtCutN(n)) / 3.0;
//        System.out.println("Final MeanAveragePrecision: " + meanAveragePrecision);
    }

    public static void jsep(String code, String req, String oracle, String change) {
        System.out.println("----------" + change + "----------");
        TextDataset textDataset = new TextDataset(code,
                req, oracle);

        Result result_ir = IR.compute(textDataset, IRModelConst.VSM_ALL, new JSS2015_CSTI(), change);
        result_ir.showMatrix();
        result_ir.showAveragePrecisionByRanklist();
        System.out.println("--------------------");
    }
}
