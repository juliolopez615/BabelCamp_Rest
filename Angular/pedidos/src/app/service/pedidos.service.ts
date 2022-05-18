import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class PedidosService {
  
  url1 = "http://localhost:10000/sproductos/producto/Productos"
  url2 = "http://localhost:10000/sproductos/producto/Precio/"
  url3 = "http://localhost:10000/spedidos/pedido/Pedidos/"
  url4 = "http://localhost:10000/spedidos/pedido/Pedido/"

  constructor(private http:HttpClient) { }

  precioProducto(codigoProducto:number){
    

  }
}
