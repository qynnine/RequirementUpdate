package exp.iTrust.change4;

import core.algo.JSS2015_CSTI;
import core.dataset.TextDataset;
import core.ir.IR;
import core.ir.IRModelConst;
import core.metrics.Result;
import exp.iTrust.ITrustSetting;

/**
 * Created by niejia on 15/12/9.
 */
public class iTrust_VSM_JSEP_Change4 {
    public static void main(String[] args) {
        TextDataset textDataset = new TextDataset(ITrustSetting.iTrust_Change4_GroupedByJSEP,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChange4);

        Result result_ir = IR.compute(textDataset, IRModelConst.VSM_ALL, new JSS2015_CSTI(), "Change4");
        result_ir.showMatrix();
        result_ir.showAveragePrecisionByRanklist();
        result_ir.showMeanAveragePrecisionByQuery();

//        int n = 35;
//        System.out.println("AveragePrecision At " + n + ": " + result_ir.getAveragePrecisionByRanklistAtCutN(n));
//
//        VisualCurve curve = new VisualCurve();
//        curve.addLine(result_ir);
//        curve.showChart();
    }
}
