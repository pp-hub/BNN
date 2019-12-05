package BNN
import chisel3._
import chisel3.util._

class ComputationModule{
 val io = IO(new Bundle{
   val feature = Input(Vec(128,UInt(4.W)))
   val weight = Input(Vec(128,UInt(1.W)))
   val accOut = Output(SInt(21.W))
   })
   
 val pe = VecInit(Seq.fill(128)(Module(new PE).io))
 val acc = new AccumlatorSet
 val adderTree = new AdderTreeGen
 
 for(i<-0 to 127)
 {
 pe(i).io.feature := io.feature(i)
 pe(i).io.weight := io.weight(i)
 adderTree.io.datain(i) := pe(i).io.fact
 } 
 acc.io.datain := adderTree.io.dataout
 io.accOut := acc.io.dataout 
}