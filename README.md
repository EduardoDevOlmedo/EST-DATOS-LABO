# Sistema de Citas del ISSS

Este repositorio contiene un programa Java que implementa un sistema de gestión de citas para el Instituto Salvadoreño del Seguro Social (ISSS). El sistema permite a los usuarios agregar, eliminar, buscar y mostrar citas médicas.

## Funcionalidades principales

1. **Agregar cita:** Los usuarios pueden agregar citas médicas especificando el día del mes y el nombre del paciente. El programa verifica si el día seleccionado está disponible y si es una fecha válida (entre 1 y 30).

2. **Eliminar cita:** Los usuarios pueden eliminar citas médicas ingresando el día del mes correspondiente. El programa verifica si la cita está programada para ese día y si es una fecha válida.

3. **Buscar cita:** Los usuarios pueden buscar citas médicas por día o por nombre de paciente. Si se busca por día, el programa indica si el día está ocupado o no. Si se busca por nombre de paciente, el programa indica si el paciente está registrado en el sistema de citas.

4. **Mostrar citas tomadas:** Esta opción muestra todas las citas médicas programadas hasta el momento, con sus respectivos días y nombres de pacientes.

## Para compilar:

```bash
javac ISSS.java && java ISSS

