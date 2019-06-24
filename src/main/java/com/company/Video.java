package com.company;

public class Video implements Displayable {
    @Override // 提示是否是正确的方法  并可以知道是否是来自上层的方法
    public void display() {
        System.out.println("implements");
    }
}
