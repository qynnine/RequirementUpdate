package exp.Aqualush.change4;

import core.algo.JSS2015_CSTI;
import core.dataset.TextDataset;
import core.ir.IR;
import core.ir.IRModelConst;
import core.metrics.Result;
import exp.Aqualush.AqualushSetting;
import visual.VisualCurve;

/**
 * Created by niejia on 15/11/29.
 */
public class Aqualush_VSM_JSEP_Change4 {
    public static void main(String[] args) {
        TextDataset textDataset = new TextDataset(AqualushSetting.Aqualush_Change4_GroupedByJSEP,
                AqualushSetting.Aqualush_CleanedRequirement, AqualushSetting.AqualushOracleChange4);

        Result result_ir = IR.compute(textDataset, IRModelConst.VSM, new JSS2015_CSTI(), "Change4");
        result_ir.showMatrix();
        result_ir.showAveragePrecisionByRanklist();
        result_ir.showMeanAveragePrecisionByQuery();

        VisualCurve curve = new VisualCurve();
        curve.addLine(result_ir);
        curve.showChart();
    }
}
