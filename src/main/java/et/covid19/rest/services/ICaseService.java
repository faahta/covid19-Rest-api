package et.covid19.rest.services;

import et.covid19.rest.swagger.model.RequestSaveCase;
import et.covid19.rest.util.exception.EthException;

public interface ICaseService {

	public boolean registerNewCase(RequestSaveCase newCase) throws EthException;
}
