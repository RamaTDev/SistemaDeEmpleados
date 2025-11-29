<%@ include file="comuns/head.jsp"%>
<%@ include file="comuns/nav.jsp"%>
    <div class="container">
        <div class="text-center">
            <h1 class="text-primary fw-bold" style="margin:30px">Empleados</h1>
        </div>
        <div class="container">
            <table class="table table-striped table-hover table-bordered align-middle">
            <thead class="table-dark text-center">
                <tr>
                <th scope="col">Id</th>
                <th scope="col">Nombre</th>
                <th scope="col">Departamento</th>
                <th scope="col">Sueldo</th>
                </tr>
            </thead>

            <tbody>
             <c:forEach var="empleado" items="${empleados}">
                   <tr>
                                <th scope="row">${empleado.idEmpleado}</th>
                                <td>${empleado.nombreEmpleado}</td>
                                <td>${empleado.departamento}</td>
                                <td>
                                    <fmt:setLocale value="en_US"/>
                                    <fmt:formatNumber type="currency" value="${empleado.sueldo}"/>
                                </td>
                   </tr>
             </c:forEach>

            </tbody>
            </table>
        </div>
    </div>

<%@ include file="comuns/footer.jsp"%>