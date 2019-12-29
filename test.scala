package BNN

import chisel3._




object TestMain extends App{
 chisel3.Driver.execute(args,()=>new ComputationModule)
}
