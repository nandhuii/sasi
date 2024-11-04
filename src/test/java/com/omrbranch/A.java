package com.omrbranch;

import java.util.ArrayList;

import lombok.AllArgsConstructor;
import lombok.Data;
@Data
@AllArgsConstructor
public class A {

private int page;
private int per_page;
private int total;
private int total_pages;
private ArrayList<B> data;
private C support;
}