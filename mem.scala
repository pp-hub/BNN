package BNN

import chisel3._
import chisel3.util._
import chisel3.experimental._

class WeightToMemIO extends Bundle{
    val addr = Vec(128,Output(12.W)) 
}
class WeightControl extends Module{
    val io = IO(new Bundle{
        val inToWe = Flipped(new InformationToWeightIO)
        val weToMem = new WeightToMemIO
    })
    val addr = RegInit(0.U(12.W))
    val count = RegInit(0.U(32.W))
    addr := Mux(count < io.inToWe.loop,addr+1.U,0.U)
    
    for(i<-0 to 127)
    {
     io.weToMem.addr(i) := addr
    }
}
