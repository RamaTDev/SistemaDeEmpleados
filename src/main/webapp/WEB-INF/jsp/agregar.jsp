 <%@ include file="comuns/head.jsp"%>
 <%@ include file="comuns/nav.jsp"%>

  <div class="container">

        <div class="text-center" style="margin: 30px;">
            <h3 class="text-primary fw-bold">Agregar Empleado</h3>
        </div>
  </div>

   <div class="container">
        <form>
            <div class="mb-3">
                <label for="nombre" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombre" required="true">
            </div>
            <div class="mb-3">
                <label for="departamento" class="form-label">Departamento</label>
                <input type="text" class="form-control" id="departamento">
            </div>
             <div class="mb-3">
                <label for="sueldo" class="form-label">Sueldo</label>
                <input type="number" step="any" class="form-control" id="sueldo">
            </div>

            <div class="text-center">
                <button type="submit" class="btn btn-success btn-sm me-3 fw-bold">Agregar</button>
                <a href="/empleados" class="btn btn-danger btn-sm fw-bold">Regresar</a>
            </div>

        </form>
   </div>

 <%@ include file="comuns/footer.jsp"%>