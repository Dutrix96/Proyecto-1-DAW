import java.time.LocalDate
import java.time.temporal.ChronoUnit
import kotlin.random.Random

class Factoria {
    companion object {
        var contadorUS = 1
        var contadorORG = 1
        var contadorEV = 1
        var ultimoUsuario: Usuario? = null
        var listaEventos = mutableListOf<Evento>()

        fun crearUsuario(): Usuario {
            var nombre = "usuario$contadorUS"
            var ID = contadorUS++
            var contraseña: Int = (Constante.INICIOPASS..Constante.FINPASS).random()
            var usuario = Usuario(ID, contraseña, nombre)
            ultimoUsuario = usuario
            return usuario
        }

        fun fechaAleatoria(): LocalDate {
            var dias = ChronoUnit.DAYS.between(Constante.INICIOFECHA, Constante.FINFECHA)
            var aleatorio = Random.nextLong(dias + 1)
            return Constante.INICIOFECHA.plusDays(aleatorio)
        }

        fun crearOrganizador(): Organizador {
            var nombre = "organizador$contadorORG"
            var IDOrg = contadorORG++
            var contraseña: Int = (Constante.INICIOPASS..Constante.FINPASS).random()
            return Organizador(IDOrg, nombre, contraseña)
        }

        fun crearEvento(): Evento {
            var IDEv = contadorEV++
            var tipo = Categoria.values().random().name
            var fecha = fechaAleatoria()
            var evento: Evento = if (Random.nextBoolean()) {
                Online(IDEv, tipo, "$tipo$IDEv", fecha)
            } else {
                Presencial(IDEv, tipo, "$tipo$IDEv", fecha)
            }
            listaEventos.add(evento)
            return evento
        }
    }
}
