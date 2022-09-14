import * as React from 'react';
import { Formik, useFormik } from 'formik';
import { Button, FormLayout, TextArea, TextField } from 'react-vaadin-components';
import Product from 'Frontend/generated/com/example/application/data/entity/Product';
import { ProductEndpoint } from 'Frontend/generated/endpoints';

const initialProduct: Product = {
  name: '',
  desctiption: ''
};

export function NewProduct(): React.ReactElement {
  const formik = useFormik({
    initialValues: initialProduct,
    onSubmit: async (values, {setSubmitting}) => {
      await ProductEndpoint.saveProduct(values);
      setSubmitting(false);
    },
  });
  return <>
    <h2>New Product</h2>
    <FormLayout responsiveSteps={ [{columns: 1}] }>
      <TextField
        name='name'
        label="Name"
        required={true}
        errorMessage={formik.errors.desctiption}
        onChange={formik.handleChange}
        onBlur={formik.handleBlur}
      ></TextField>
      <TextArea
        name='description'
        label="Description"
        errorMessage={formik.errors.desctiption}
        onChange={formik.handleChange}
        onBlur={formik.handleBlur}
      ></TextArea>
      <Button
        disabled={formik.isSubmitting}
        onClick={formik.submitForm}>Submit</Button>
    </FormLayout>
  </>;
}
