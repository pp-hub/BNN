package BNN
import chisel3._
import chisel3.util._

class ComputationModule extends Module{
 val io = IO(new Bundle{
   val feature = Input(Vec(128,UInt(4.W)))
   val weight = Input(Vec(128,UInt(1.W)))
   val accOut = Output(SInt(21.W))
   val clear = Input(Bool())
   val valid = Input(Bool())
   val validin = Input(Bool())
   })
   
 val pe = VecInit(Seq.fill(128)(Module(new PE).io))
 val acc = Module(new AccumulatorSet)
 val adderTree = Module(new AdderTreeGen)
 
 for(i<-0 to 127)
 {
 pe(i).feature := io.feature(i)
 pe(i).weight := io.weight(i)
 adderTree.io.datain(i) := pe(i).fact
 } 
 acc.io.datain := adderTree.io.dataout
 io.accOut := acc.io.dataout 
 acc.io.clear := io.clear
 acc.io.validin := io.validin
 adderTree.io.valid := io.valid
}