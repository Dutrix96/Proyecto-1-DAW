fun main() {
    var organizador = Factoria.crearOrganizador()
    var usuario = Factoria.crearUsuario()
    var i = Constante.INIT
    while (i < Constante.NUMEROEVENTOS) {
        Factoria.crearEvento()
        i++
    }
    println("Organizador creado: $organizador")
    println("Usuario creado: $usuario")
    println("Total de eventos creados: ${Factoria.listaEventos.size}")
    usuario.apuntarse()
}