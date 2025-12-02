<!-- Agregar los url de la aplicacion -->

<c:set var="urlInicio">
    <c:url value="${application.contextPath}/" />
</c:set>

<c:set var="urlAgregar">
    <c:url value="${application.contextPath}/agregar" />
</c:set>

  <div class="container">
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark px-2 bg-primary" data-bs-theme="dark">
            <a class="navbar-brand fw-bold fs-3" href="${urlInicio}">Sistema De Empleados</a>

            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item active">
                        <a class="nav-link text-warning fs-3" href="${urlInicio}">Inicio</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link text-info fw fs-3" href="${urlAgregar}">Agregar Empleado</a>
                    </li>
                </ul>
            </div>
        </nav>
  </div>