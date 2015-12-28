package exp.iTrust.changeV11;

import core.algo.RegionBased_CSTI;
import core.dataset.TextDataset;
import core.ir.IR;
import core.ir.IRModelConst;
import core.metrics.Result;
import exp.iTrust.ITrustSetting;

/**
 * Created by niejia on 15/12/24.
 */
public class ITrust_VSM_JSEP_MyVersion_ChangeV11 {

    public static void main(String[] args) {
        TextDataset textDataset = new TextDataset(ITrustSetting.iTrust_Change11_GroupedByJSEP_MyVersion,
                ITrustSetting.iTrust_CleanedRequirement, ITrustSetting.iTrustOracleChangeV11);

        Result result_ir = IR.compute(textDataset, IRModelConst.VSM_ALL, new RegionBased_CSTI(), "iTrust");
        result_ir.showMatrix();
        result_ir.showAveragePrecisionByRanklist();
        result_ir.showMeanAveragePrecisionByQuery();
//
//        int n = 35;
//        System.out.println("AveragePrecision At " + n + ": " + result_ir.getAveragePrecisionByRanklistAtCutN(n));
//
//        VisualCurve curve = new VisualCurve();
//        curve.addLine(result_ir);
//        curve.showChart();
    }


}
