<%@ include file="common/header.jspf"%>
        <div class="container">
            <%@ include file="common/navigation.jspf"%>
        </div>
        <div class="container">
            <h2>Enter Todos Details</h2>
            <form:form method="post" modelAttribute="todo">
                <fieldset class="mb-3">
                    <form:label path="description">Description</form:label>
                    <form:input type="text" path="description" required="required" />
                    <form:errors path="description" cssClass="text-warning"/>
                </fieldset>
                <fieldset class="mb-3">
                    <form:label path="targetDate">Target Date</form:label>
                    <form:input type="text" path="targetDate" required="required"/>
                    <form:errors path="targetDate" cssClass="text-warning"/>
                </fieldset>

                <form:input type="hidden" path="id" required="required" />
                <form:input type="hidden" path="done" required="required" />
                <input type="submit" class="btn btn-success">
            </form:form>
        </div>
        <script type="text/javascript">
            $('#targetDate').datepicker({
                format: 'yyyy-mm-dd'
            });
        </script>
<%@ include file="common/footer.jspf"%>