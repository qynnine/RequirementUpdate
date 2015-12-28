package exp.Aqualush.change457;

import core.algo.JSS2015_CSTI;
import core.dataset.TextDataset;
import core.ir.IR;
import core.ir.IRModelConst;
import core.metrics.Result;
import exp.Aqualush.AqualushSetting;

/**
 * Created by niejia on 15/12/3.
 */
public class Aqualush_VSM_JSEP_MyVersion_Change457 {
    public static void main(String[] args) {
        TextDataset textDataset4 = new TextDataset(AqualushSetting.Aqualush_Change4_GroupedByJSEP_MyVersion,
                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange4);

        Result result_ir4 = IR.compute(textDataset4, IRModelConst.VSM_ALL, new JSS2015_CSTI(), "Change4");
        System.out.println("Change4");
        result_ir4.showAveragePrecisionByRanklist();
        result_ir4.showMeanAveragePrecisionByQuery();
        System.out.println("---------------------- ");

        TextDataset textDataset5 = new TextDataset(AqualushSetting.Aqualush_Change5_GroupedByJSEP_MyVersion,
                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange5);

        Result result_ir5 = IR.compute(textDataset5, IRModelConst.VSM_ALL, new JSS2015_CSTI(), "Change5");
        System.out.println("Change5");
        result_ir5.showAveragePrecisionByRanklist();
        result_ir5.showMeanAveragePrecisionByQuery();
        System.out.println("---------------------- ");

        TextDataset textDataset7 = new TextDataset(AqualushSetting.Aqualush_Change7_GroupedByJSEP_MyVersion,
                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange7);

        Result result_ir7 = IR.compute(textDataset7, IRModelConst.VSM_ALL, new JSS2015_CSTI(), "Change7");
        System.out.println("Change7");
        result_ir7.showAveragePrecisionByRanklist();
        result_ir7.showMeanAveragePrecisionByQuery();
        System.out.println("---------------------- ");

        int n = 20;
        double meanAveragePrecision = (result_ir4.getAveragePrecisionByRanklistAtCutN(n) + result_ir5.getAveragePrecisionByRanklistAtCutN(n) +
                result_ir7.getAveragePrecisionByRanklistAtCutN(n)) / 3.0;
        System.out.println("Final MeanAveragePrecision: " + meanAveragePrecision);
    }
}
