import React, { Component, PropTypes } from 'react';

import 
{
	 StyleSheet,
	 TouchableOpacity,
     TextInput,
	 Text,
	 View
} 
from 'react-native';

import Communications from 'react-native-communications';

const localStyle = StyleSheet.create({

    simpleText: {
		 fontSize: 20,
		 textAlign: 'left',
	 },

     buttonText: {
		 fontSize: 20,
		 textAlign: 'center',
	 },
})

export class SubmitForm extends Component
{
    constructor()
    {
        super();
    }

    render()
    {
        return (
            <View>
				<TextInput
					style = {localStyle.simpleText}
					onChangeText = {(text) => this.setState({text})}
					placeholder = 'Location name'
				/>
				<TextInput
					style = {localStyle.simpleText}
	    			onChangeText = {(text) => this.setState({text})}
					placeholder = 'Description'
                />
				<TouchableOpacity onPress = {() => Communications.email(['foloba.anca@gmail.com', 'foloba.anca@gmail.com'], null, null, 'RN', 'bla')}>
					<Text style = {localStyle.buttonText}> Submit </Text>
	    		</TouchableOpacity>
				<TouchableOpacity onPress = {this.props.onBack}>
					<Text style = {localStyle.buttonText}> Back </Text>
	    		</TouchableOpacity>
			</View>
        )
    }
}

SubmitForm.proptype = {
    onBack: PropTypes.func.isRequired,
};