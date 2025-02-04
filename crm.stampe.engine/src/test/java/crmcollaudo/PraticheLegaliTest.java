package crmcollaudo;

import com.fideuram.crm.stampe.engine.CrmStampeService;
import com.fideuram.puc.service.impl.StampeServiceImpl;

/**
 * Utilizzare jdk 1.8 con compiler 1.6
 */
public class PraticheLegaliTest {
	public static void main(String args[]) {
		new CrmStampeService().elaboraMessaggio(12731601);
	}
}
