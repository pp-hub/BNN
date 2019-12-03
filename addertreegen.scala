package BNN

import chisel3._
import chisel3.util._

class AdderTreeGen(num:Int){
   val io = IO(new Bundle{
    val datain = Input(Vec(2<<num,UInt(4.W)))
	 val dataout = Output(SInt((4+num).W))
   })
   val adder =  VecInit(Seq.fill(2<<(num-1))(Module(new SIntFourMFour).io))
   val 
}
