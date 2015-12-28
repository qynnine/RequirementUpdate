package exp.iTrust.change7;

import core.algo.JSS2015_CSTI;
import core.dataset.TextDataset;
import core.ir.IR;
import core.ir.IRModelConst;
import core.metrics.Result;
import exp.iTrust.ITrustSetting;
import visual.VisualCurve;

/**
 * Created by niejia on 15/12/14.
 */
public class iTrust_VSM_ChangeRegion_Change7 {
    public static void main(String[] args) {
        TextDataset textDataset = new TextDataset(ITrustSetting.iTrust_Change7_GroupedByMethod,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange7);

        Result result_ir = IR.compute(textDataset, IRModelConst.VSM, new JSS2015_CSTI(), "Change7");
        result_ir.showMatrix();
        result_ir.showAveragePrecisionByRanklist();
        result_ir.showMeanAveragePrecisionByQuery();

        int n = 35;
        System.out.println("AveragePrecision At " + n + ": " + result_ir.getAveragePrecisionByRanklistAtCutN(n));

        VisualCurve curve = new VisualCurve();
        curve.addLine(result_ir);
        curve.showChart();
    }
}