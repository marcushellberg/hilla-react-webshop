import * as React from 'react';
import { FormikErrors, useFormik } from 'formik';
import { Button, FormLayout, TextArea, TextField } from 'react-vaadin-components';
import { ProductEndpoint } from 'Frontend/generated/endpoints';
import { EndpointValidationError } from '@hilla/frontend';
import ProductDTO from "Frontend/generated/com/example/application/data/dto/ProductDTO";

const initialProduct: ProductDTO = {
  name: '',
  description: ''
};

type FormField<T> = {
  name: string,
  label: string,
  value: T,
  required: boolean,
  errorMessage?: string,
  onChange: (e: Event) => void,
  onBlur: (e: Event) => void,
};

export function NewProduct(): React.ReactElement {
  const formik = useFormik({
    initialValues: initialProduct,
    onSubmit: async (values, {setSubmitting, setErrors}) => {
      try {
        await ProductEndpoint.saveProduct(values);
      } catch (e: unknown) {
        if (e instanceof EndpointValidationError) {
          const errors: FormikErrors<ProductDTO> = {}
          for (const error of e.validationErrorData) {
            if (typeof error.parameterName === 'string' && error.parameterName in initialProduct) {
              const key = error.parameterName as (string & keyof ProductDTO);
              errors[key] = error.message;
            }
          }
          setErrors(errors);
        }
      } finally {
        setSubmitting(false);
      }
    },
  });
  return <>
    <h2>New Product</h2>
    <FormLayout responsiveSteps={ [{columns: 1}] }>
      <TextField
        name='name'
        label='Name'
        required={true}
        value={formik.values.name}
        errorMessage={formik.errors.name}
        onChange={formik.handleChange}
        onBlur={formik.handleChange}
      ></TextField>
      <TextArea
        name='description'
        label="Description"
        value={formik.values.description}
        errorMessage={formik.errors.description}
        onChange={formik.handleChange}
        onBlur={formik.handleBlur}
      ></TextArea>
      <Button
        disabled={formik.isSubmitting}
        onClick={formik.submitForm}>Submit</Button>
    </FormLayout>
  </>;
}
