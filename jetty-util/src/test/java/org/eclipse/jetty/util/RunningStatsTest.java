package org.eclipse.jetty.util;

import junit.framework.TestCase;


/* ------------------------------------------------------------ */
/**
 * Test data and results used in this test are from National Institute
 * of Standards and Technology Information Technology Laboratory study.
 * 
 * http://www.itl.nist.gov/div898/handbook/eda/section3/eda359.htm
 */
public class RunningStatsTest extends TestCase
{
    private static double[] data1 = {608.781,689.556,618.134,680.203,726.232,518.655,740.447,666.830,710.272,751.669,697.979,708.583,624.972,695.070,769.391,720.186,723.657,703.700,697.626,714.980,657.712,609.989,650.771,707.977,712.199,709.631,703.160,744.822,719.217,619.137,753.333,677.933,735.919,695.274,504.167,693.333,625.000,596.667,640.898,720.506,700.748,691.604,636.738,731.667,635.079,716.926,759.581,673.903,736.648,675.957,729.230,697.239,728.499,797.662,668.530,815.754,777.392,712.140,663.622,684.181,629.012,640.193,644.156,642.469,639.090,439.418,614.664,537.161,656.773,659.534,695.278,734.040,687.665,710.858,701.716,382.133,719.744,756.820,690.978,670.864,670.308,660.062,790.382,714.750,716.959,603.363,713.796,444.963,723.276,745.527,778.333,723.349,708.229,681.667,566.085,687.448,597.500,637.410,755.864,692.945,766.532,725.663,698.818,760.000,775.272,708.885,727.201,642.560,690.773,688.333,743.973,682.461,761.430,691.542,643.392,697.075,708.229,746.467,744.819,655.029,715.224,614.417,761.363,716.106,659.502,730.781,546.928,734.203,682.051,701.341,759.729,689.942,769.424,715.286,776.197,547.099,619.942,696.046,573.109,638.794,708.193,502.825,632.633,683.382,684.812,738.161,671.492,709.771,685.199,624.973,757.363,633.417,658.754,664.666,663.009,773.226,708.261,739.086,667.786,674.481,695.688,588.288,545.610,752.305,684.523,717.159,721.343,750.623,776.488,750.623,600.840,686.196,687.870,725.527,658.796,690.380,737.144,663.851,766.630,625.922,694.430,730.217,700.770,722.242,763.828,695.668,688.887,531.021,698.915,735.905,732.039,751.832,618.663,744.845,690.826,666.893,759.860,683.752,729.591,730.706,763.124,724.193,630.352,750.338,752.417,707.899,715.582,728.746,591.193,592.252,740.833,786.367,712.386,738.333,741.480,729.167,795.833,723.502,718.333,768.080,747.500,775.000,760.599,758.333,682.500,658.116,738.213,681.236,704.904,693.623,624.993,700.228,611.874,579.167,720.872,690.320,677.933,674.600,611.999,530.680};
    private static double[] data2 = {569.670,747.541,612.182,607.766,605.380,589.226,588.375,531.384,633.417,619.060,632.447,624.256,575.143,549.278,624.972,587.695,569.207,613.257,565.737,662.131,543.177,512.394,611.190,659.982,569.245,725.792,608.960,586.060,617.441,592.845,631.754,588.113,555.724,702.411,631.754,698.254,616.791,551.953,636.738,571.551,521.667,587.451,700.422,595.819,534.236,606.188,575.303,590.628,729.314,619.313,624.234,651.304,724.175,583.034,620.227,584.861,565.391,622.506,628.336,587.145,584.319,538.239,538.097,595.686,648.935,583.827,534.905,569.858,617.246,610.337,584.192,598.853,554.774,605.694,627.516,574.522,582.682,563.872,715.962,616.430,778.011,604.255,571.906,625.925,682.426,707.604,617.400,689.576,676.678,563.290,581.879,447.701,557.772,593.537,632.585,671.350,569.530,581.667,643.449,581.593,494.122,620.948,615.903,606.667,579.167,662.510,436.237,644.223,586.035,620.833,652.535,593.516,587.451,570.964,645.192,540.079,707.117,621.779,585.777,703.980,698.237,757.120,621.751,472.125,612.700,583.170,599.771,549.227,605.453,569.599,637.233,621.774,558.041,583.170,345.294,570.999,603.232,595.335,581.047,455.878,627.880,464.085,596.129,640.371,621.471,612.727,606.460,571.760,599.304,579.459,761.511,566.969,654.397,611.719,577.409,576.731,617.441,577.409,548.957,623.315,621.761,553.978,657.157,610.882,552.304,545.303,651.934,635.240,641.083,645.321,566.127,647.844,554.815,620.087,711.301,644.355,713.812,696.707,589.453,634.468,599.751,624.542,723.505,674.717,608.539,612.135,591.935,676.656,647.323,811.970,603.883,608.643,630.778,623.063,472.463,645.932,577.176,567.530,821.654,684.490,600.427,686.023,628.109,605.214,640.260,700.767,665.924,555.926,543.299,511.030,583.994,611.048,623.338,679.585,665.004,655.860,715.711,611.999,577.722,615.129,540.316,711.667,639.167,549.491,684.167,672.153,594.534,627.650,551.870,594.534,602.660,585.450,555.724,574.934,584.625,555.724,611.874,698.254,748.130,689.942};
    
    public void testData1()
        throws Exception
    {
        RunningStats stats = new RunningStats();
        
        for (double x : data1)
            stats.update(x);
    
        assertEquals(data1.length, stats.getSize());
        assertEquals(688.9986, round(stats.getMean(), 4));
        assertEquals(4296.683, round(stats.getVariance(), 3));
        assertEquals(65.54909, round(stats.getStdDev(), 5));
    }

    public void testData2()
        throws Exception
    {
        RunningStats stats = new RunningStats();
        
        for (double x : data2)
            stats.update(x);
    
        assertEquals(data2.length, stats.getSize());
        assertEquals(611.1560, round(stats.getMean(), 4));
        assertEquals(3825.948, round(stats.getVariance(), 3));
        assertEquals(61.85425, round(stats.getStdDev(), 5));
    }

    private double round(double x, int places)
    {
        return Math.round(x * Math.pow(10.0, (double) places)) / Math.pow(10.0, (double) places);
    }
}