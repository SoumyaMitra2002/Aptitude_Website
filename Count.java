/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tech.blog.entities;

/**
 *
 * @author hp
 */
public class Count {
    private int count;
    
    public Count(int count) {
        this.count=count;
    }

    public int getCount() {
        return ++count;
    }
    
    
    
}
