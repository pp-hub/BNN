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
    
}
