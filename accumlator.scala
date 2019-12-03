package BNN

import chisel3._
import chisel3.util._

class AccumlatorSet(num:Int){
 val io = IO(new Bundle{
    val datain = Input(SInt(11.W))
	val dataout = Output(SInt(21.W))
    val validin = Input(Bool()) 
    val clear = Input(Bool())	
 })
   val acc = VecInit(Seq.fill(128)(Module(new Accumlator).io)) 
   val count = RegInit(0.U(128.W))
   when(io.validin)
   {
    count := count+1.U
   }
   val x = for(i <- 0 to 127)
            yield count === i.U
  
   val y = for(i <- 0 until 127)
            yield 1.U << i
  
   val decode = MuxCase(0.U, x zip y)
   
   for(i<-0 to 127)
   {
    acc(i).io.B := io.datain
	acc(i).io.CLK := clock
	acc(i).io.CE := decode(i)
	acc(i).io.SCLR := decode(i)&&io.clear
   }
   io.dataout := acc(count).io.Q
   io.validout := 
}