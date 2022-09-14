import React from 'react';
import { Field, FieldProps } from 'formik';
import { TextArea } from 'react-vaadin-components';

export const FormikTextArea = ({ name, onChange, onValueChanged, ...rest }: React.ComponentProps<typeof TextArea>) => {
  const ref = React.useRef<typeof TextArea.TextAreaElement>(null);

  const validate = () => ref.current?.validate() ? '' : 'Invalid';

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
