package api.dominio;

public enum EstadoDelegacion {
    ESPERA,
    RECHAZADA,
    ACEPTADA;

    public static EstadoDelegacion fromInteger(int n) {
        switch(n) {
            case 0:
                return ESPERA;
            case 1:
                return RECHAZADA;
            case 2:
                return ACEPTADA;
        }
        return null;
    }


}
