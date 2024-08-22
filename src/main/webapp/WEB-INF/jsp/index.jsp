<%@ include file="comunes/cabecera.jsp"%>
<%@ include file="comunes/navegacion.jsp"%>



<div class="container">
    <div class="text-center" style="margin: 30px">
        <h3>Sistema de empleados</h3>
    </div>
    <div class="container">
        <table class="table table-striped table-hover table-bordered align-middle">
            <thead class="table-dark text-center">
            <tr>
                <th scope="col">id</th>
                <th scope="col">Nombre</th>
                <th scope="col">Departamento</th>
                <th scope="col">Sueldo</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="empleado" items="${listaEmpleados}">
                <tr>
                    <th scope="row">${empleado.idEmpleado}</th>
                    <td>${empleado.nombreEmpleado}</td>
                    <td>${empleado.departamento}</td>
                    <td>
                            <fmt:setLocale value="en_US"/>
                            <fmt:formatNumber type="currency" value="${empleado.sueldo}"/>

                </tr>
            </c:forEach>

            </tbody>
        </table>


    </div>
</div>

<%@ include file="comunes/pie-pagina.jsp"%>
