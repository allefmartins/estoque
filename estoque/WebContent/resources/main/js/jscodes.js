function handleRequest(xhr, status, args, dialog) {
	if (args.validationFailed || args.KEEP_DIALOG_OPENED) {
		PF(dialog).jq.effect("shake", {
			times : 5
		}, 100);
	} else {
		PF(dialog).hide();
	}
}