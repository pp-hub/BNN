package BNN

import chisel3._
import chisel3.util._
import chisel3.experimental._
class InformationToWeightIO extends Bundle{
    val inputC = Output(UInt(10.W))
    val outputC = Output(UInt(10.W))
    val tp = Output(UInt(8.W))
    val floop = Output(UInt(32.W))
    val kloop = Output(UInt(8.W)) 
    val loop = Output(UInt(32.W))
}
class InformationToWeightIO extends Bundle{}
class InformationToConfigIO extends Bundle{
    val config = Input(Vec(6,UInt(16.W))
    val addr = Output(UInt(8.W))
}
class Information extends Module{
    val io = IO(new Bundle{
      val inToWe = new InformationToWeightIO
      val inToConfig = new InformationToConfigIO
      val inTofe = new InformationToFeatureIO
      val fsmToIn = new FsmToInformationIO
      
    })

   val valid1 := RegNext(RegNext(io.fsmToIn.valid))
   val mul =  VecInit(Seq.fill(4)(Module(new MUL).io)))
   mul(0).A := io.inToConfig.config(3)
   mul(0).B := io.inToConfig.config(3)
   mul(0).CE := io.fsmToIn.valid
   

   mul(1).A := io.inToConfig.config(4)
   mul(1).B := io.inToConfig.config(4)
   mul(1).CE := io.fsmToIn.valid 

   mul(2).A := io.inToConfig.config(0)>>io.inToConfig.config(2)
   mul(2).B := io.inToConfig.config(1)>>io.inToConfig.config(2)
   mul(2).CE := io.fsmToIn.valid
   
   mul(3).A := mul(2).P
   mul(3).B := mul(1).P
   mul(3).CE := valid1
   /*
   mul(4).A := mul(1).P
   mul(4).B := io.inToConfig.config(0)>>io.inToConfig.config(2)
   mul(4).CE := valid1
   */
   io.inToWe.inputC := io.inToConfig.config(0)
   io.inToWe.outputC := io.inToConfig.config(1)
   io.inToWe.tp := io.inToConfig.config(2)
   io.inToWe.floop := mul(0).P 
   io.inToWe.kloop := mul(1).P
   io.inToWe.loop := mul(3).P
}