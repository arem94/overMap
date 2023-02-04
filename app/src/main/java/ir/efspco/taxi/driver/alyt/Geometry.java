package ir.efspco.taxi.driver.alyt;


import android.util.Log;

public class Geometry {
    public static APoint findRelativePosition(APoint point, APoint tl, APoint tr, APoint bl, APoint br) {
        float areaW = areaTriangle(tl, point, bl);
        float areaN = areaTriangle(tl, point, tr);
        float areaS = areaTriangle(bl, point, br);
        float areaE = areaTriangle(tr, point, br);

        float x = distance2Point(tl, bl);
        float y = distance2Point(tl, tr);
        float areaAll = x * y;
        if ((int)(areaAll*100000)< (int)((areaW + areaS + areaE + areaN)*100000) ){
            return null;

        }
        float x1 = areaW * 2 * 100 / areaAll;
        float y1 = areaN * 2 * 100 / areaAll;
        return new APoint(x1, y1);
    }


    public static float distance2Point(APoint a, APoint b) {
        return (float) Math.sqrt((b.y - a.y) * (b.y - a.y) + (b.x - a.x) * (b.x - a.x));
    }

    /**
     * Java method to return area of triangle using vertices as per following
     * formula area = (Ax(By -Cy) + Bx(Cy -Ay) + Cx(Ay - By))/2
     * @return
     */
    public static float areaTriangle(APoint A, APoint B, APoint C) {
        float area = (float) ((A.x * (B.y - C.y) + B.x * (C.y - A.y) + C.x * (A.y - B.y)) / 2.0f);
        return Math.abs(area);
    }

    /**
     * * @param base * @param height * @return
     */
    public static float areaTriangle(int base, int height) {
        return (base * height) / 2.0f;
    }
}
