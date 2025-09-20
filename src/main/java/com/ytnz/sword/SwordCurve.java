package com.ytnz.sword;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.world.phys.Vec3;

import java.util.List;

public class SwordCurve {
    private static double curveTime = 0;

    public static void SwordMove(List<Sword> swords, Vec3 playerPosition) {
        curveTime += 2;
        if(curveTime > 10000) {curveTime = 0;}
        if (curveTime % 12 == 0){
            for (int i = 0; i < swords.size(); i++) {
                if (i % 2 == 0){
                    double[] pos = circleMove(curveTime / 8 + i * 50 ,playerPosition.x, playerPosition.y, playerPosition.z);
                    swords.get(i).setPos(pos[0],pos[1],pos[2]);
                }
                else {
                    double[] pos = circleMove( curveTime / 8 + i * 50,playerPosition.x, playerPosition.y, playerPosition.z);
                    swords.get(i).setPos(pos[0],pos[1],pos[2]);
                }
            }
        }
    }

    public static void SwordPoseReplace(List<Sword> swords) {
        for (Sword sword : swords) {
            PoseStack pose = new PoseStack();
            pose.pushPose();

        }
    }

    public static double[] circleMove(double t,double cx, double cy, double cz) {
        double r = 6;
        double x = cx + r * Math.cos(t / 100);
        double y = cy + r * Math.sin(t / 100);
        double z = cz;
        return new double[]{x,y,z};
    }

    /**
     * 实现绕指定点(cx,cy,cz)的三维螺旋线运动
     * @param t 控制运动的参数（通常表示时间或角度）
     * @param cx 围绕点的X坐标
     * @param cy 围绕点的Y坐标
     * @param cz 围绕点的Z坐标
     * @return 包含x, y, z坐标的double数组
     */
    public static double[] spiral3DMotion(double t, double cx, double cy, double cz) {
        // 设置螺旋线参数
        double baseRadius = 10;          // 基础半径
        double maxRadius = 8;           // 最大半径
        double minRadius = 7;           // 最小半径
        double heightAmplitude = 4;     // 高度振幅
        double angularSpeed = 1;        // 角速度
        double radiusOscillationSpeed = 0.5; // 半径振荡速度

        // 计算周期性变化的半径
        double radiusVariation = (maxRadius - minRadius) * 0.5;
        double radiusOffset = radiusVariation * Math.sin(radiusOscillationSpeed * t);
        double currentRadius = baseRadius + radiusOffset;

        // 计算周期性变化的高度
        double zVariation = heightAmplitude * Math.sin(angularSpeed * 0.7 * t);

        // 计算相对于中心点的坐标
        double xOffset = currentRadius * Math.cos(angularSpeed * t);
        double yOffset = currentRadius * Math.sin(angularSpeed * t);
        double zOffset = zVariation;  // 使用正弦函数使高度周期性变化

        // 加上中心点坐标
        double x = cx + xOffset;
        double y = cy + yOffset;
        double z = cz + zOffset;


        return new double[]{x, y, z};
    }

    /**
     * 实现绕指定点(cx,cy,cz)的三维椭圆螺旋线运动
     * @param t 控制运动的参数（通常表示时间或角度）
     * @param cx 围绕点的X坐标
     * @param cy 围绕点的Y坐标
     * @param cz 围绕点的Z坐标
     * @return 包含x, y, z坐标的double数组
     */
    public static double[] ellipticalSpiral3DMotion(double t, double cx, double cy, double cz) {
        double aBase = 10;  // x轴基础半径
        double bBase = 10;  // y轴基础半径
        double aAmplitude = 0.5; // x轴半径变化幅度
        double bAmplitude = 0.3; // y轴半径变化幅度
        double zAmplitude = 3; // z轴振幅

        // 使用不同的角速度创造更复杂的运动
        double angularSpeedXY = 0.8;   // XY平面旋转角速度
        double angularSpeedZ = 1.3;    // Z轴变化角速度
        double radiusOscillationSpeed = 0.7; // 半径振荡速度

        // 计算周期性变化的椭圆半径
        double aVariation = aAmplitude * Math.sin(radiusOscillationSpeed * t);
        double bVariation = bAmplitude * Math.cos(radiusOscillationSpeed * t * 1.3); // 使用不同频率

        // 当前椭圆半径
        double aCurrent = aBase + aVariation;
        double bCurrent = bBase + bVariation;

        // 计算相对于中心点的坐标
        // 使用不同的相位创造更复杂的椭圆轨迹
        double xOffset = aCurrent * Math.cos(angularSpeedXY * t);
        double yOffset = bCurrent * Math.sin(angularSpeedXY * t + Math.PI/4); // 添加相位偏移

        // Z轴使用独立的正弦波，与XY平面运动不同步
        double zOffset = zAmplitude * Math.sin(angularSpeedZ * t);

        // 加上中心点坐标
        double x = cx + xOffset;
        double y = cy + yOffset;
        double z = cz + zOffset;

        return new double[]{x, y, z};
    }


}
