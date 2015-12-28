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
public class Aqualush_VSM_ChangeRegion_Change457 {
    public static void main(String[] args) {
//        TextDataset textDataset4 = new TextDataset(AqualushSetting.Aqualush_Change4_GroupedByMethod,
//                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange4);
//
//        Result result_ir4 = IR.compute(textDataset4, IRModelConst.VSM, new RegionBased_CSTI(), "Change4");
//        System.out.println("Change4");
//        result_ir4.showAveragePrecisionByRanklist();
//        result_ir4.showMeanAveragePrecisionByQuery();
//        System.out.println("---------------------- ");
//
//        TextDataset textDataset5 = new TextDataset(AqualushSetting.Aqualush_Change5_GroupedByMethod,
//                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange5);
//
//        Result result_ir5 = IR.compute(textDataset5, IRModelConst.VSM, new RegionBased_CSTI(), "Change5");
//        System.out.println("Change5");
//        result_ir5.showAveragePrecisionByRanklist();
//        result_ir5.showMeanAveragePrecisionByQuery();
//        System.out.println("---------------------- ");
//
//        TextDataset textDataset7 = new TextDataset(AqualushSetting.Aqualush_Change7_GroupedByMethod,
//                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange7);
//
//        Result result_ir7 = IR.compute(textDataset7, IRModelConst.VSM, new RegionBased_CSTI(), "Change7");
//        System.out.println("Change7");
//        result_ir7.showAveragePrecisionByRanklist();
//        result_ir7.showMeanAveragePrecisionByQuery();
//        System.out.println("---------------------- ");
        changeRegion(AqualushSetting.Aqualush_Change4_GroupedByMethod, AqualushSetting.Aqualush_CleanedRequirement,
                AqualushSetting.AqualushOracleChange4, "Change4");


        changeRegion(AqualushSetting.Aqualush_Change5_GroupedByMethod, AqualushSetting.Aqualush_CleanedRequirement,
                AqualushSetting.AqualushOracleChange5, "Change5");

        changeRegion(AqualushSetting.Aqualush_Change7_GroupedByMethod, AqualushSetting.Aqualush_CleanedRequirement,
                AqualushSetting.AqualushOracleChange7, "Change7");
//
//        int n = 20;
//        double meanAveragePrecision = (result_ir4.getAveragePrecisionByRanklistAtCutN(n) + result_ir5.getAveragePrecisionByRanklistAtCutN(n) +
//                result_ir7.getAveragePrecisionByRanklistAtCutN(n)) / 3.0;
//        System.out.println("Final MeanAveragePrecision: " + meanAveragePrecision);
    }


    public static void changeRegion(String code, String req, String oracle, String change) {
        System.out.println("----------" + change + "----------");
        TextDataset textDataset = new TextDataset(code,
                req, oracle);

        Result result_ir = IR.compute(textDataset, IRModelConst.VSM_ALL, new JSS2015_CSTI(), change);
//        result_ir.showMatrix();
        result_ir.showAveragePrecisionByRanklist();
        System.out.println("--------------------");
    }
}
