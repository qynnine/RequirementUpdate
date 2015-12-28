package exp.Aqualush.change457;

import core.algo.MergeTwoExpert;
import core.algo.RegionBased_CSTI;
import core.dataset.TextDataset;
import core.ir.IR;
import core.ir.IRModelConst;
import core.metrics.Result;
import document.SimilarityMatrix;
import exp.Aqualush.AqualushSetting;

/**
 * Created by niejia on 15/12/2.
 */
public class Aqualush_VSM_MergedExperts_Change457 {
    public static void main(String[] args) {
        TextDataset textDataset4 = new TextDataset("data/Aqualush/cleaned_commit/change4",
                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange4);

        Result result_ir4 = IR.compute(textDataset4, IRModelConst.VSM, new MergeTwoExpert(getExpertSM4()), "Change4");
        result_ir4.showAveragePrecisionByRanklist();
        TextDataset textDataset5 = new TextDataset("data/Aqualush/cleaned_commit/change5",
                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange5);

        Result result_ir5 = IR.compute(textDataset5, IRModelConst.VSM, new MergeTwoExpert(getExpertSM5()), "Change5");
        result_ir5.showAveragePrecisionByRanklist();
        TextDataset textDataset7 = new TextDataset("data/Aqualush/cleaned_commit/change7",
                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange7);

        Result result_ir7 = IR.compute(textDataset7, IRModelConst.VSM, new MergeTwoExpert(getExpertSM7()), "Change7");
        result_ir7.showAveragePrecisionByRanklist();
        int n = 20;
        double meanAveragePrecision = (result_ir4.getAveragePrecisionByRanklistAtCutN(n) + result_ir5.getAveragePrecisionByRanklistAtCutN(n) +
                result_ir7.getAveragePrecisionByRanklistAtCutN(n)) / 3.0;
        System.out.println("Final MeanAveragePrecision: " + meanAveragePrecision);
    }

    private static SimilarityMatrix getExpertSM4() {
        TextDataset textDataset = new TextDataset(AqualushSetting.Aqualush_Change4_GroupedByJSEP,
                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange4);

        Result result_ir = IR.compute(textDataset, IRModelConst.VSM, new RegionBased_CSTI(), "Change4");
        return result_ir.getMatrix();
    }

    private static SimilarityMatrix getExpertSM5() {
        TextDataset textDataset = new TextDataset(AqualushSetting.Aqualush_Change5_GroupedByJSEP,
                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange5);

        Result result_ir = IR.compute(textDataset, IRModelConst.VSM, new RegionBased_CSTI(), "Change5");
        return result_ir.getMatrix();
    }

    private static SimilarityMatrix getExpertSM7() {
        TextDataset textDataset = new TextDataset(AqualushSetting.Aqualush_Change7_GroupedByJSEP,
                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange7);

        Result result_ir = IR.compute(textDataset, IRModelConst.VSM, new RegionBased_CSTI(), "Change7");
        return result_ir.getMatrix();
    }
}
