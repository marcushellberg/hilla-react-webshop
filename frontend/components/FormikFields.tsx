import React from 'react';
import { Field, FieldProps } from 'formik';
import { TextArea, TextField } from 'react-vaadin-components';
// TODO: Why export from rvc doesn't do it?
import type { TextArea as TextAreaElement } from '@vaadin/text-area';

export const FormikTextArea = ({ name, onChange, onValueChanged, ...rest }: React.ComponentProps<typeof TextArea>) => {
  const ref = React.useRef<TextAreaElement>(null);

  const validate = () => {
    if (!ref.current?.checkValidity()) {
      return 'Invalid';
    }
  };

  return (
    <Field name={name} validate={validate}>
      {({ field: { value }, form: { setFieldValue, setFieldTouched, errors, isValid } }: FieldProps) => {
        return (
          <TextArea
            ref={ref}
            value={value}
            invalid={!isValid}
            onValueChanged={(e: CustomEvent<{ value: string }>) =>
              queueMicrotask(() => setFieldValue(name!, e.detail.value, !isValid))
            }
            errorMessage={errors.description ? String(errors.description) : undefined}
            onChange={() => setFieldTouched(name!, true, false)}
            {...rest}
          />
        );
      }}
    </Field>
  );
};
