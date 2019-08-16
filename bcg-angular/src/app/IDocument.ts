export interface IDocument {
	"empId": number,
	"docTypeId": number,
	"verificationDTO": {
		"status": string,
		"requestStartDate": Date,
		"requestEndDate": Date
	}
}