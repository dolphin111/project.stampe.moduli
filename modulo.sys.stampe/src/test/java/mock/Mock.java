package mock;

/**
 * Created by
 * User: logan
 * Date: 15/02/12
 * Time: 12.47
 */
public class Mock {


        private String nome;
        private String cognome;
        private Integer eta;

        public String getNome() {
            return nome;
        }

        public void setNome(String nome) {
            this.nome = nome;
        }

        public Integer getEta() {
            return eta;
        }

        public void setEta(Integer eta) {
            this.eta = eta;
        }

        public String getCognome() {
            return cognome;
        }

        public void setCognome(String cognome) {
            this.cognome = cognome;
        }

        public static Mock getM1(){
            Mock m = new Mock();
            m.setNome("Paolo");
            m.setCognome("Paolino");
            m.setEta(new Integer(33));
            return m;
        }

        public static Mock getM2(){
            Mock m = new Mock();
            m.setNome("Pietro");
            m.setCognome("Paolinozz");
            m.setEta(new Integer(33));
            return m;
        }


}
