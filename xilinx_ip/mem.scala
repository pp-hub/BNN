package BNN

import chisel3._
import chisel3.util._
import chisel3.experimental._

class WeightBuffer extends BlackBox{
    val io =IO(new Bundle{
      val clka = Input(Clock())
      val ena = Input(Bool())  
      val wea = Input(Bool())
      val addra = Input(UInt(12.W))
      val dina = Input(UInt(128.W))
      val douta = Output(UInt(128.W))
    })
}

class FeatureBuffer extends BlackBox{
    val io =IO(new Bundle{
      val clka = Input(Clock())
      val ena = Input(Bool())  
      val wea = Input(Bool())
      val addra = Input(UInt(10.W))
      val dina = Input(UInt(512.W))
      val douta = Output(UInt(512.W))
    })   
}