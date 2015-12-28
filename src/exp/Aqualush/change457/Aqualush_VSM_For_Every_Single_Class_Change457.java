package exp.Aqualush.change457;

import core.algo.RegionBased_CSTI;
import core.dataset.TextDataset;
import core.ir.IR;
import core.ir.IRModelConst;
import core.metrics.Result;
import exp.Aqualush.AqualushSetting;

/**
 * Created by niejia on 15/12/2.
 */
public class Aqualush_VSM_For_Every_Single_Class_Change457 {
    public static void main(String[] args) {
        TextDataset textDataset4 = new TextDataset(AqualushSetting.Aqualush_Change4_For_Every_Single_Class,
                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange4);

        Result result_ir4 = IR.compute(textDataset4, IRModelConst.VSM, new RegionBased_CSTI(), "Change4");
        System.out.println("Change4");
        result_ir4.showAveragePrecisionByRanklist();
        result_ir4.showMeanAveragePrecisionByQuery();
        System.out.println("---------------------- ");

        TextDataset textDataset5 = new TextDataset(AqualushSetting.Aqualush_Change5_For_Every_Single_Class,
                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange5);

        Result result_ir5 = IR.compute(textDataset5, IRModelConst.VSM, new RegionBased_CSTI(), "Change5");
        System.out.println("Change5");
        result_ir5.showAveragePrecisionByRanklist();
        result_ir5.showMeanAveragePrecisionByQuery();
        System.out.println("---------------------- ");

        TextDataset textDataset7 = new TextDataset(AqualushSetting.Aqualush_Change7_For_Every_Single_Class,
                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange7);

        Result result_ir7 = IR.compute(textDataset7, IRModelConst.VSM, new RegionBased_CSTI(), "Change7");
        System.out.println("Change7");
        result_ir7.showAveragePrecisionByRanklist();
        result_ir7.showMeanAveragePrecisionByQuery();
        System.out.println("---------------------- ");
    }
}
