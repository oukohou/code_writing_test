package oukohou.fire_and_shoot.sensetime;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by oukohou on 2017/9/17.
 * <p>
 * If this runs wrong, don't ask me, I don't know why;
 * If this runs right, thank god, and I don't know why.
 * Maybe the answer, my friend, is blowing in the wind.
 */

class DataPoint {
    float x, y;

    public DataPoint(float x, float y) {
        this.x = x;
        this.y = y;
    }
}


public class LineFit {

    private double sumX;

    private double sumY;

    private double sumXX;

    private double sumXY;

    private double sumYY;

    private double sumDeltaY;

    private double sumDeltaY2;
    private double sse;
    private double sst;
    private double E;
    private String[] xy;
    private ArrayList listX;
    private ArrayList listY;
    private int XMin, XMax, YMin, YMax;

    private float a0;
    private float a1;
    private int pn;
    private boolean coefsValid;

    public int getDataPointCount() {
        return pn;
    }

    public float getA0() {
        validateCoefficients();
        return a0;
    }

    public float getA1() {
        validateCoefficients();
        return a1;
    }

    public double getSumX() {
        return sumX;
    }


    public double getSumY() {
        return sumY;
    }

    public double getSumXX() {
        return sumXX;
    }

    public double getSumXY() {
        return sumXY;
    }

    public double getSumYY() {
        return sumYY;
    }

    public int getXMin() {
        return XMin;
    }

    public int getXMax() {
        return XMax;
    }

    public int getYMin() {
        return YMin;
    }

    public int getYMax() {
        return YMax;
    }

    public void addDataPoint(DataPoint dataPoint) {
        sumX += dataPoint.x;
        sumY += dataPoint.y;
        sumXX += dataPoint.x * dataPoint.x;
        sumXY += dataPoint.x * dataPoint.y;
        sumYY += dataPoint.y * dataPoint.y;

        if (dataPoint.x > XMax) {
            XMax = (int) dataPoint.x;
        }
        if (dataPoint.y > YMax) {
            YMax = (int) dataPoint.y;
        }

        // 把每个点的具体坐标存入ArrayList中，备用
        xy[0] = (int) dataPoint.x + "";
        xy[1] = (int) dataPoint.y + "";
        if (dataPoint.x != 0 && dataPoint.y != 0) {
            System.out.print(xy[0] + ",");
            System.out.println(xy[1]);

            try {
                // System.out.println("n:"+n);
                listX.add(pn, xy[0]);
                listY.add(pn, xy[1]);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        ++pn;
        coefsValid = false;
    }

    public float at(int x) {
        if (pn < 2)
            return Float.NaN;

        validateCoefficients();
        return a0 + a1 * x;
    }

    public void reset() {
        pn = 0;
        sumX = sumY = sumXX = sumXY = 0;
        coefsValid = false;
    }

    /**
     * Validate the coefficients. 计算方程系数 y=ax+b 中的a
     */
    private void validateCoefficients() {
        if (coefsValid)
            return;

        if (pn >= 2) {
            float xBar = (float) sumX / pn;
            float yBar = (float) sumY / pn;

            a1 = (float) ((pn * sumXY - sumX * sumY) / (pn * sumXX - sumX
                    * sumX));
            a0 = (float) (yBar - a1 * xBar);
        } else {
            a0 = a1 = Float.NaN;
        }

        coefsValid = true;
    }

    public double getR() {
        // 遍历这个list并计算分母
        for (int i = 0; i < pn - 1; i++) {
            float Yi = (float) Integer.parseInt(listY.get(i).toString());
            float Y = at(Integer.parseInt(listX.get(i).toString()));
            float deltaY = Yi - Y;
            float deltaY2 = deltaY * deltaY;

            sumDeltaY2 += deltaY2;

        }

        sst = sumYY - (sumY * sumY) / pn;
        // System.out.println("sst:" + sst);
        E = 1 - sumDeltaY2 / sst;

        return round(E, 4);
    }

    // 用于实现精确的四舍五入
    public double round(double v, int scale) {

        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }

        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).doubleValue();

    }

    public float round(float v, int scale) {

        if (scale < 0) {
            throw new IllegalArgumentException(
                    "The scale must be a positive integer or zero");
        }

        BigDecimal b = new BigDecimal(Double.toString(v));
        BigDecimal one = new BigDecimal("1");
        return b.divide(one, scale, BigDecimal.ROUND_HALF_UP).floatValue();

    }

    public void printrResult() {
        double sum = getA1() * getA1() + getA0() * getA0();
        sum = Math.sqrt(sum);

        double x = getA1() / sum;
        double y = getA1() / sum;

        System.out.printf(".6f .6f", x, y);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();

        LineFit lineFit = new LineFit();
        while (n-- > 0) {
            DataPoint dataPoint = new DataPoint(scanner.nextFloat(), scanner.nextFloat());
            lineFit.addDataPoint(dataPoint);
        }
        lineFit.printrResult();
    }
}
