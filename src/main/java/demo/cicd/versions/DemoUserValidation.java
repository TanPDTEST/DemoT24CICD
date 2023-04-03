package demo.cicd.versions;

import com.temenos.api.TField;
import com.temenos.api.TStructure;
import com.temenos.api.TValidationResponse;
import com.temenos.t24.api.complex.eb.templatehook.TransactionContext;
import com.temenos.t24.api.hook.system.RecordLifecycle;
import com.temenos.t24.api.records.user.UserRecord;

/**
 * TODO: Document me!
 *
 * @author SG-E0002
 *
 */
public class DemoUserValidation extends RecordLifecycle {

    @Override
    public TValidationResponse validateRecord(String application, String currentRecordId, TStructure currentRecord,
            TStructure unauthorisedRecord, TStructure liveRecord, TransactionContext transactionContext) {
        UserRecord curRec = new UserRecord(currentRecord);
        TField lgField = curRec.getLanguage();
        if ("4".equals(lgField.getValue())) {
            lgField.setError("Language 4 is not allowed");
        }
        return curRec.getValidationResponse();
    }

}
