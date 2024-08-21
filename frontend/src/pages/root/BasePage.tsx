import { Container } from "@mui/material"
import Background from "./components/Background"
import Header from "./components/Header"
import React from "react"

type BasePageProps = {
    children?: React.ReactNode;
  }

const BasePage: React.FC<BasePageProps> = ({children}) => {
  return (
    <>
    <Background/>
    <Container>
        <Header/>
        {children}
    </Container>
    </>
  )
}

export default BasePage