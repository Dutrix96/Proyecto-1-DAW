 class Usuario {
        var IDUsuario = 0
        var contraseña = 0
        var nombre = ""
        var eventosApuntados = mutableListOf<Evento>()

        constructor() {}
        constructor(IDUsuario: Int, contraseña: Int, nombre: String) {
            this.IDUsuario = IDUsuario
            this.contraseña = contraseña
            this.nombre = nombre
        }

     fun apuntarse() {
         println("Quieres apuntarte a algun evento?")
         var apunt = readln().trim().lowercase()
         if (apunt == "si") {
             var continuar = true
             while (continuar) {
                 println("Eventos disponibles:")
                 var i = 0
                 while (i < Factoria.listaEventos.size) {
                     var evento = Factoria.listaEventos[i]
                     if (!eventosApuntados.contains(evento)) {
                         val tipoEvento = if (evento is Online) "Online" else "Presencial"
                         println("ID: " + evento.IDEvento + " - Nombre: " + evento.nombre + " - Tipo: $tipoEvento")
                     }
                     i++
                 }
                 println("Introduce el ID del evento al que quieres apuntarte: ")
                 var input = readln()
                 var idSeleccionado = input.toIntOrNull()
                 var eventoSeleccionado: Evento? = null
                 var j = 0
                 while (j < Factoria.listaEventos.size) {
                     var evento = Factoria.listaEventos[j]
                     if (evento.IDEvento == idSeleccionado && !eventosApuntados.contains(evento)) {
                         eventoSeleccionado = evento
                     }
                     j++
                 }
                 if (eventoSeleccionado == null) {
                     println("ID no válido o ya estás apuntado a este evento.")
                 } else {
                     val tipoEvento = if (eventoSeleccionado is Online) "Online" else "Presencial"
                     println("Te has apuntado al evento: " + eventoSeleccionado.nombre + " - Tipo: $tipoEvento")
                     eventosApuntados.add(eventoSeleccionado)
                 }
                 println("¿Quieres apuntarte a otro evento? (si/no)")
                 var respuesta = readln().trim().lowercase()
                 continuar = respuesta == "si"
             }
             println("Te has apuntado a los siguientes eventos:")
             var k = 0
             while (k < eventosApuntados.size) {
                 var evento = eventosApuntados[k]
                 val tipoEvento = if (evento is Online) "Online" else "Presencial"
                 println("ID: " + evento.IDEvento + " - Nombre: " + evento.nombre + " - Tipo: $tipoEvento")
                 k++
             }
         }
         else {
             print("\rSaliendo.    ")
             Thread.sleep(500)
             print("\rSaliendo..   ")
             Thread.sleep(500)
             print("\rSaliendo...  ")
         }
     }

     override fun toString(): String {
         return "Usuario(IDUsuario=$IDUsuario, contraseña=$contraseña, nombre='$nombre')"
     }

 }