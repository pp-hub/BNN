package BNN

import chisel3._
import chisel3.util._

class AdderTreeGen(num:Int){
   val io = IO(new Bundle{
    val datain = Input(Vec(num,UInt(4.W)))
	val dataout = Output()
   })
}